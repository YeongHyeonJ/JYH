package kr.green.green.controller;

import java.io.FileInputStream;
import java.io.InputStream;
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

import kr.green.green.pagination.Criteria;
import kr.green.green.pagination.PageMaker;
import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;



@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value="/list")
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		//게시글에 대한 정보를 boardService를 통해 가져온다 조건은 "NORMAL"
		//List<BoardVO> list = boardService.getBoardList("NORMAL");
		//Criteria 설정 중 페이지에 나오는 게시글 수 설정
		cri.setPerPageNum(6);
		//BoardList를 가져와서 List에 저장
		List<BoardVO> list = boardService.getBoardList( cri);
		int totalCount = boardService.getTotalCount( cri);
		//System.out.println(totalCount);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		mv.addObject("pm",pm);
		mv.addObject("list",list);
		//System.out.println(list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		//System.out.println(bd_num);
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> files = boardService.getFileList(bd_num);
		boardService.updateViews(bd_num);
		//System.out.println(board);
		mv.addObject("board",board);
		mv.addObject("files", files);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv,
			Integer bd_ori_num, String bd_type) {
		//게시글을 작성하기위해 bd_ori_num과 bd_type정보를 가져온다.
		mv.addObject("bd_type",bd_type);
		mv.addObject("bd_ori_num",bd_ori_num);
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, 
			HttpServletRequest request, List<MultipartFile> files2) throws Exception{
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		boardService.registerBoard(board, files2);
		mv.addObject("type", board.getBd_type());
		//System.out.println(files2);
		mv.setViewName("redirect:/board/list");
		
		//System.out.println(board);
		return mv;
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,
			Integer bd_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		boardService.deleteBoard(bd_num,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv,
			Integer bd_num, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoard(bd_num, user);
		
		List<FileVO> fileList = boardService.getFileList(bd_num);
		mv.addObject("fileList",fileList);
		mv.addObject("board", board);
		mv.setViewName("/board/modify");
		
		return mv;
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board,
			List<MultipartFile> files2, Integer [] fileNums,
			HttpServletRequest request) {
		boardService.updateBoard(board, files2, fileNums);
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		//집
		String uploadPath = "C:\\\\Users\\\\dudgu\\\\OneDrive\\\\바탕 화면\\\\GIT\\\\upload";
		//학원
		//String uploadPath = "D:\\JAVA_JYH\\upload";
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
	
	@ResponseBody
	@RequestMapping(value="/likes")
	public String boardLikes(@RequestBody LikesVO likes, 
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return boardService.likes(likes, user);
	}
	@ResponseBody
	@RequestMapping(value="/likes/views")
	public String loadLikes(@RequestBody LikesVO likes,
			HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		return boardService.views(likes,user);
	}
	
}
