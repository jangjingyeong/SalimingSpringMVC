package kr.co.saliming.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.saliming.member.domain.Member;
import kr.co.saliming.member.service.MemberService;

@Controller
@SessionAttributes({"memberId", "memberName"})
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
	public String showRegisterMember(Model model) {
		return "member/enroll";
	}
	
	@RequestMapping(value = "/member/register.do", method = RequestMethod.POST)
	public String registerMember(
			@RequestParam("id") String memberId
			, @RequestParam("pw") String memberPw
			, @RequestParam("pw2") String memberPw2
			, @RequestParam("name") String memberName
			, @RequestParam("nickname") String memberNickname
			, @RequestParam("birth") String memberBirthday
			, @RequestParam("tel") String memberPhone
			, @RequestParam("email") String memberEmail
			, @RequestParam("postcode") String postcode
			, @RequestParam("address") String address
			, @RequestParam("detailAddress") String detailAddress
			, Model model
			) {
		
		try {
			String memberAddress = postcode + address + detailAddress;
			
			Member member = new Member(memberId, memberPw, memberPw2, memberName, memberNickname, memberBirthday, memberPhone, memberEmail, memberAddress);
			int result = service.insertMember(member);
			if(result > 0) {
				// ����
				model.addAttribute("msg", "ȸ������ �����߾��.");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceSuccess";
			} else {
				// ���� 
				model.addAttribute("msg", "ȸ�������� �Ϸ���� �ʾҽ��ϴ�.");
				model.addAttribute("url", "/index.jsp");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String showLoginMember(Model model) {
		return "member/login";
	}
	
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String memberLogin(
			@RequestParam("id") String memberId
			, @RequestParam("pw") String memberPw
			, Model model) {
		try {
			Member member = new Member(memberId, memberPw);
			Member mOne = service.selectCheckLogin(member);
			if(mOne != null) {
				// �α��� ���� 
				model.addAttribute("memberId", mOne.getMemberId());
				model.addAttribute("memberName", mOne.getMemberName());
				return "redirect:/index.jsp";
			} else {
				// �α��� ���� 
				model.addAttribute("msg", "�����Ͱ� ��ȸ���� �ʾҽ��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public String memberLogout(
			SessionStatus session
			, Model model) {
		try {
			if(session != null) {
				session.setComplete();
				if(session.isComplete()) {
					// ���� ���� ��ȿ�� üũ 
					// �ȿ� ������ else ������ �ϴϱ� isComplete()����.
				}
				return "redirect:/index.jsp";
			} else {
				model.addAttribute("msg","�α׾ƿ��� �Ϸ����� ���߽��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
		
	}
	
	@RequestMapping(value = "/member/mypage.do", method = RequestMethod.GET)
	public String showMypage(Model model) {
		return "member/mypage";
	}

	@RequestMapping(value = "/member/myinfo.do", method=RequestMethod.GET)
	public String showDetailMember(
			Model model
			, @RequestParam("memberId") String memberId) {
		try {
			Member member = service.selectOneById(memberId);
			if(member != null) {
				model.addAttribute("member", member);
				return "member/myinfo";
			} else {
				model.addAttribute("msg", "�����Ͱ� ��ȸ���� �ʾҽ��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value = "/member/update.do", method=RequestMethod.POST)
	public String modifyMember(
			Model model
			, @RequestParam("id") String memberId 
			, @RequestParam("pw") String memberPw 
			, @RequestParam("pw2") String memberPw2
			, @RequestParam("nickname") String memberNickname
			, @RequestParam("tel") String memberPhone 
			, @RequestParam("email") String memberEmail
			, @RequestParam("postcode") String postcode
			, @RequestParam("address") String address
			, @RequestParam("detailAddress") String detailAddress
			, RedirectAttributes redirect) {
		try {
			String memberAddress = postcode + address + detailAddress;
			Member member = new Member(memberId, memberPw, memberPw2, memberNickname, memberPhone, memberEmail, memberAddress);
			int result = service.updateMember(member);
			if(result > 0) {
				redirect.addAttribute("memberId", memberId);
				return "redirect:/member/myinfo.do";
			} else {
				model.addAttribute("msg", "ȸ������������ �Ϸ���� �ʾҽ��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	@RequestMapping(value="/member/delete.do", method = RequestMethod.GET)
	public String removeMember(
			@RequestParam("memberId") String memberId
			, Model model) {
		try {
			int result = service.deleteMember(memberId);
			if(result > 0) {
				return "redirect:/member/logout.do";
			} else {
				model.addAttribute("msg", "ȸ�� Ż�� �Ϸ���� �ʾҽ��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/serviceFailed";
		}
	}
	
	
	
}
