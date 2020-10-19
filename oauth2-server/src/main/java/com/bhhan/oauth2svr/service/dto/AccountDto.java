package com.bhhan.oauth2svr.service.dto;

import com.bhhan.oauth2svr.domain.Account;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */
public class AccountDto {
    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountInfo {
        private String id;
        private String name;
        private String email;

        @Builder
        public AccountInfo(Account account){
            this.id = String.valueOf(account.getId());
            this.name = account.getName();
            this.email = account.getEmail();
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountReq {
        @Email(message = "잘못된 Email 형식입니다.")
        private String email;

        private String name;

        @Pattern(regexp = "^[!@#$%^&*A-Za-z0-9_-]{8,20}$", message = "잘못된 Password 형식입니다.")
        private String password;

        @NotNull(message = "항상 Role을 포함해야 합니다.")
        @Size(min = 1, message = "Role은 1개 이상 입니다.")
        private List<Long> roleIds;

        @Builder
        public AccountReq(String name, String email, String password, List<Long> roleIds){
            this.name = name;
            this.email = email;
            this.password = password;
            this.roleIds = roleIds;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountClientDetailsReq implements Serializable {
        @NotNull(message = "ACCOUNT_ID는 필수입니다.")
        private Long accountId;

        @NotNull(message = "ClientDetailsDto는 필수입니다.")
        private ClientDetailsDto clientDetailsDto;

        @Builder
        public AccountClientDetailsReq(Long accountId, ClientDetailsDto clientDetailsDto){
            this.accountId = accountId;
            this.clientDetailsDto = clientDetailsDto;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AccountClientDetailsRes {
        private Long accountId;
        private ClientDetailsDto clientDetailsDto;

        @Builder
        public AccountClientDetailsRes(Long accountId, ClientDetailsDto clientDetailsDto){
            this.accountId = accountId;
            this.clientDetailsDto = clientDetailsDto;
        }
    }
}
