package me.simonpojok.quickorder.mapper.base

abstract class BaseUiToPresentationMapper<UI, PRESENTATION> {
    abstract fun toPresentation(ui: UI): PRESENTATION
}