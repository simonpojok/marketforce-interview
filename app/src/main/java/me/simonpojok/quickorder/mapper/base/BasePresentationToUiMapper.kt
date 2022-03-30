package me.simonpojok.quickorder.mapper.base

abstract class BasePresentationToUiMapper<UI, PRESENTATION> {
    abstract fun toUi(presentation: PRESENTATION): UI
}