package me.simonpojok.data.mapper.base

abstract class BaseDomainToDataMapper<DOMAIN, DATA> {
    abstract fun toData(domain: DOMAIN): DATA
}