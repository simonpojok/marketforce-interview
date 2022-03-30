package me.simonpojok.domain.usecase.base

abstract class BaseUseCase<T, in Input> {
    abstract suspend fun buildUseCase(input: Input? = null): T
}