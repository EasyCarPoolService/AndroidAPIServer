package com.example.AndroidAPIServer.dto.report;

import com.example.AndroidAPIServer.domain.entity.ReportEntity;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReportDto {

    private String report_title;
    private String report_content;
    private String report_user_email;

    public ReportEntity toEntity(){
        return ReportEntity.builder()
                .report_title(report_title)
                .report_content(report_content)
                .report_user_email(report_user_email)
                .build();
    }

}



