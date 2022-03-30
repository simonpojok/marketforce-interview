package me.simonpojok.quickorder.mapper.base

abstract class BasePresentationToUiMapper<PRESENTATION, UI> {
    abstract fun toUi(presentation: PRESENTATION): UI
}