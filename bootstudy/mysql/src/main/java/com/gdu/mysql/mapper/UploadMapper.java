package com.gdu.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.mysql.domain.AttachDTO;
import com.gdu.mysql.domain.UploadDTO;

@Mapper
public interface UploadMapper {
	public List<UploadDTO> selectUploadList();
	public int insertUpload(UploadDTO upload);
	public int insertAttach(AttachDTO attach);
	public UploadDTO selectUploadByNo(int uploadNo);
	public List<AttachDTO> selectAttachList(int uploadNo);
	public int updateDownloadCnt(int attachNo);
	public AttachDTO selectAttachByNo(int attachNo);
	public int updateUpload(UploadDTO upload);
	public int deleteAttach(int attachNo);
	public int deleteUpload(int uploadNo);
	public List<AttachDTO> selectAttachListInYesterday();
}
