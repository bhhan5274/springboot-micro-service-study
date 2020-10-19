package com.bhhan.oauth2svr.config;

import com.bhhan.oauth2svr.domain.Account;
import com.bhhan.oauth2svr.domain.Role;
import com.bhhan.oauth2svr.service.AccountService;
import com.bhhan.oauth2svr.service.RoleService;
import com.bhhan.oauth2svr.service.dto.AccountDto;
import com.bhhan.oauth2svr.service.dto.ClientDetailsDto;
import com.bhhan.oauth2svr.service.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.assertj.core.util.Sets;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hbh5274@gmail.com on 2020-10-19
 * Github : http://github.com/bhhan5274
 */

@Configuration
@RequiredArgsConstructor
public class InitConfig {
    private final AccountService accountService;
    private final RoleService roleService;
    private final OAuth2Properties oAuth2Properties;

    @Bean
    public CommandLineRunner initData(){
        return args -> {
            List<Long> savedRoleIds = new ArrayList<>();

            oAuth2Properties.getRoles()
                    .forEach(role -> {
                        savedRoleIds.add(roleService.addRole(RoleDto.RoleReq.builder().name(role).build()).getId());
                    });

            Account account = accountService.addAccount(AccountDto
                    .AccountReq.builder()
                    .name(oAuth2Properties.getName())
                    .email(oAuth2Properties.getEmail())
                    .password(oAuth2Properties.getPassword())
                    .roleIds(savedRoleIds)
                    .build());

            final ClientDetailsDto clientDetailsDto = ClientDetailsDto.builder()
                    .clientId(oAuth2Properties.getClientId())
                    .clientSecret(oAuth2Properties.getClientSecret())
                    .webServerRedirectUri(Sets.newLinkedHashSet("http://authorization_code/redirect_url"))
                    .authorizedGrantTypes(Sets.newLinkedHashSet("authorization_code", "password"))
                    .scope(Sets.newLinkedHashSet("read", "write"))
                    .build();

            accountService.addClientDetailsWithClientIdAndClientSecret(account.getId(), clientDetailsDto);
        };
    }
}
