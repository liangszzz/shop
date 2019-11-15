package com.github.ls.ssoservice.service;

import com.github.ls.ssoservice.dao.OauthClientDetailsDao;
import com.github.ls.ssoservice.entity.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OauthService {

    private final OauthClientDetailsDao oauthClientDetailsDao;

    @Autowired
    public OauthService(OauthClientDetailsDao oauthClientDetailsDao) {
        this.oauthClientDetailsDao = oauthClientDetailsDao;
    }

    public List<OauthClientDetails> all() {
        return oauthClientDetailsDao.findAll();
    }
}
