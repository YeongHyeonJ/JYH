package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.LikesVO;
import kr.green.spring.vo.MemberVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@RequestMapping(value="/list")
	public ModelAndView boardList(ModelAndView mv,Criteria cri) {
		//보이는 게시글 수
		cri.setPerPageNum(6);
		List<BoardVO> list = boardService.getBoardList( cri);
		//페이지 메이커를 만들어야함
		int totalCount = boardService.getTotalCount( cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		mv.addObject("pm",pm);
		
		mv.addObject("list",list);
		//System.out.println(list);
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv,
			Integer bd_ori_num, String bd_type) {
		mv.addObject("bd_type",bd_type);
		mv.addObject("bd_ori_num",bd_ori_num);
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, 
			HttpServletRequest request, List<MultipartFile> files2) throws Exception {
		System.out.println(files2);
		//공지를 작성할때 관리자와 슈퍼관리자만 작성하도록 하는 코드
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		List<String> authorityAdmin = new ArrayList<String>();
		authorityAdmin.add("관리자");
		authorityAdmin.add("슈퍼 관리자");
		if(	board.getBd_type().equals("공지") &&
				authorityAdmin.indexOf(user.getMe_authority()) < 0) {
			mv.addObject("type", "공지");
			mv.setViewName("redirect:/board/list");
		}else {
			boardService.registerBoard(board, files2);
			mv.addObject("type", board.getBd_type());
			mv.setViewName("redirect:/board/list");
		}
		//System.out.println(board);
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//System.out.println(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> files = boardService.getFileList(bd_num);
		boardService.updateViews(bd_num);
		//System.out.println(board);
		mv.addObject("board", board);
		mv.addObject("files", files);
		//System.out.println(files);
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		//게시글 번호 확인
		//System.out.println(bd_num);
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//System.out.println(user);
		boardService.deleteBoard(bd_num,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		//System.out.println(bd_num);
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoard(bd_num, user);
		//System.out.println(board);
		
		if(board == null) {
			mv.setViewName("redirect:/board/list");
		}else {
			List<FileVO> fileList = boardService.getFileList(bd_num);
			mv.addObject("fileList",fileList);
			mv.addObject("board", board);
			mv.setViewName("/board/modify");
		}
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board,
			List<MultipartFile> files2, Integer [] fileNums,
			HttpServletRequest request) {
		// 기존 첨부파일 번호인 fileNums 확인
//		if(fileNums != null) {
//			for(Integer tmp : fileNums)
//				System.out.println(tmp);
//		}
		// 다오에게 게시글 정보를 주면서 업데이트 하라고 시킴
		boardService.updateBoard(board, files2, fileNums);
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		// 화면에서 수정한 게시글 정보가 넘어오는지 확인
		//System.out.println(board);
		
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/likes")
	public String boardLikes(@RequestBody LikesVO likes,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//System.out.println(user);
		//System.out.println(likes);
		return boardService.likes(likes, user);
	}
	@ResponseBody
	@RequestMapping(value="/viewlikes")
	public String boardViewLikes(@RequestBody LikesVO likes,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//System.out.println(user);
		//System.out.println(likes);
		return boardService.viewLikes(likes, user);
	}
	
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		//학원
		//String uploadPath = "D:\\JAVA_JYH\\upload";
		//집
		String uploadPath = "C:\\\\Users\\\\dudgu\\\\OneDrive\\\\바탕 화면\\\\GIT\\\\upload";
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}

}
