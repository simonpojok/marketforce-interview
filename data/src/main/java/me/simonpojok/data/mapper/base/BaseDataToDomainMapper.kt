package me.simonpojok.data.mapper.base

abstract class BaseDataToDomainMapper<DATA, DOMAIN> {
    abstract fun toDomain(data: DATA): DOMAIN
}