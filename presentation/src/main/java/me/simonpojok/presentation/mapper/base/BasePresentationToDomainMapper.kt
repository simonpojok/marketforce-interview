package me.simonpojok.presentation.mapper.base

abstract class BasePresentationToDomainMapper<DOMAIN, PRESENTATION> {
    abstract fun toDomain(presentation: PRESENTATION): DOMAIN
}