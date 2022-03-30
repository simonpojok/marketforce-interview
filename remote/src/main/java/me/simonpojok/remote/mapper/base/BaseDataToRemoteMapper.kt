package me.simonpojok.remote.mapper.base

abstract class BaseDataToRemoteMapper<REMOTE, DATA> {
    abstract fun toRemote(data: DATA): REMOTE
}