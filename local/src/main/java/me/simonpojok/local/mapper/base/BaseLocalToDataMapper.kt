package me.simonpojok.local.mapper.base

abstract class BaseLocalToDataMapper<LOCAL, DATA> {
    abstract fun toData(data: LOCAL): DATA
}