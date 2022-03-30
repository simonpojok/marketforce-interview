package me.simonpojok.domain.usecase.base

abstract class FlowableBaseUseCase<T, in Input>  {
    abstract fun buildUseCase(input: Input? = null): T
}