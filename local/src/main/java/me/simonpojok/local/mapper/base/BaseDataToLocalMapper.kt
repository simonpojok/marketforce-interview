package me.simonpojok.local.mapper.base

abstract class BaseDataToLocalMapper<DATA, LOCAL> {
    abstract fun toLocal(data: DATA): LOCAL
}