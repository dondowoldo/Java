package com.example.urlaliasertrial.dto;

import com.example.urlaliasertrial.model.Alias;

public record AliasDTO(Long id, String url, String alias, Integer hitCount) {

    public AliasDTO(Alias alias) {
        this(alias.getId(), alias.getLink().getUrl(), alias.getAlias(), alias.getHitCount());
    }
}
