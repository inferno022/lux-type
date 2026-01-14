package org.luxtype.inputmethod.v2keyboard

import org.luxtype.inputmethod.event.Combiner
import org.luxtype.inputmethod.event.DeadKeyCombiner
import org.luxtype.inputmethod.event.combiners.NFCNormalizingCombiner
import org.luxtype.inputmethod.event.combiners.DeadKeyPreCombiner
import org.luxtype.inputmethod.event.combiners.KoreanCombiner
import org.luxtype.inputmethod.event.combiners.wylie.WylieCombiner

enum class CombinerKind(val factory: () -> Combiner) {
    DeadKey({ DeadKeyCombiner() }),
    DeadKeyPreCombiner({ DeadKeyPreCombiner() }),
    NFCNormalize({ NFCNormalizingCombiner() }),
    Korean({ KoreanCombiner() }),
    KoreanCombineInitials({ KoreanCombiner(combineInitials = true) }),
    Wylie({ WylieCombiner() }),
}
