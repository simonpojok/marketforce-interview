package me.simonpojok.presentation.mapper.base

abstract class BaseDomainToPresentationMapper<DOMAIN, PRESENTATION> {
    abstract fun toPresentation(domain: DOMAIN): PRESENTATION
}