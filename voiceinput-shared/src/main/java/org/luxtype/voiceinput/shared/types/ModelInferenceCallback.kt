package org.luxtype.voiceinput.shared.types

enum class InferenceState {
    ExtractingMel, LoadingModel, Encoding, DecodingLanguage, SwitchingModel, DecodingStarted
}

interface ModelInferenceCallback {
    fun updateStatus(state: InferenceState)
    fun languageDetected(language: Language)
    fun partialResult(string: String)
}
