package kr.co.saliming.member.domain;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberPw2;
	private String memberName;
	private String memberNickname;
	private String memberBirthday;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private Timestamp memberDate;
	private Timestamp updateDate;
	private String memberYn;
	
	// �⺻������
	public Member() {}

	// ���Կ������
	public Member(String memberId, String memberPw, String memberPw2, String memberName, String memberNickname,
			String memberBirthday, String memberPhone, String memberEmail, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPw2 = memberPw2;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberBirthday = memberBirthday;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}
	
	// �α��ο�
	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	// ������
	public Member(String memberId, String memberPw, String memberPw2, String memberNickname, String memberPhone,
			String memberEmail, String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPw2 = memberPw2;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}

	
	
	// getter, setter 
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberPw2() {
		return memberPw2;
	}

	public void setMemberPw2(String memberPw2) {
		this.memberPw2 = memberPw2;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Timestamp getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Timestamp memberDate) {
		this.memberDate = memberDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getMemberYn() {
		return memberYn;
	}

	public void setMemberYn(String memberYn) {
		this.memberYn = memberYn;
	}

	@Override
	public String toString() {
		return "ȸ�� [���̵�=" + memberId + ", ��й�ȣ=" + memberPw + ", ��й�ȣȮ��=" + memberPw2 + ", �̸�="
				+ memberName + ", �г���=" + memberNickname + ", ����=" + memberBirthday
				+ ", ��ȭ��ȣ=" + memberPhone + ", �̸���=" + memberEmail + ", �ּ�=" + memberAddress
				+ ", ������=" + memberDate + ", ������=" + updateDate + ", ȸ������=" + memberYn + "]";
	}

	
	
}

