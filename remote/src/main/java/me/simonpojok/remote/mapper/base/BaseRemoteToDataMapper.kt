package me.simonpojok.remote.mapper.base

abstract class BaseRemoteToDataMapper<REMOTE, DATA> {
    abstract fun toData(remote: REMOTE): DATA
}