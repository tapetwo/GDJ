package com.gdu.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.notice.domain.NoticeDTO;

@Mapper
public interface NoticeMapper {

	public List<NoticeDTO> selectAllNotices();
	public int insertNotice(NoticeDTO notice);

	// findNoticeByNo
	public NoticeDTO selectNoticeByNo(int noticeNo); // NoticeDTO result와 연결 , noticeNo parameter와 연결
	public int updateHit(int noticeNo);
	
	public int updateNotice(NoticeDTO notice);
	public int deleteNotice(int noticeNo);
	
	
}
