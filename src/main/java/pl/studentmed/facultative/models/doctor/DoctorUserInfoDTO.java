package pl.studentmed.facultative.models.doctor;

import pl.studentmed.facultative.models.user_info.IUserInfoDTO;
import pl.studentmed.facultative.models.user_info.UserInfoResponseDTO;

public record DoctorUserInfoDTO(Long doctorId, String specialization, UserInfoResponseDTO userInfoResponseDTO) implements IUserInfoDTO {
}