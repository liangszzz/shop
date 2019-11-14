package com.github.ls.ssoservice.service;

import com.github.ls.sso.dao.OauthClientDetailsDao;
import com.github.ls.sso.entity.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OauthService {

    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    public List<OauthClientDetails> all() {
        return oauthClientDetailsDao.findAll();
    }
}
