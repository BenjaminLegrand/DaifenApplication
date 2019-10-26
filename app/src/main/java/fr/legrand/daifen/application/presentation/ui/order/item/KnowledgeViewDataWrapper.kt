package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Knowledge
import fr.legrand.daifen.application.data.values.KnowledgeType

data class KnowledgeViewDataWrapper(
    private val knowledge: Knowledge
) {
    fun getKnowledgeTypeText(context: Context): String =
        when (knowledge.type) {
            KnowledgeType.PULLEY -> context.getString(R.string.knowledge_pulley)
            KnowledgeType.ARCHITECTURE -> context.getString(R.string.knowledge_architecture)
            KnowledgeType.ARROWS -> context.getString(R.string.knowledge_arrows)
            KnowledgeType.HORSE -> context.getString(R.string.knowledge_horse)
            KnowledgeType.MYSTICISM -> context.getString(R.string.knowledge_mysticism)
            KnowledgeType.EXPLORATION -> context.getString(R.string.knowledge_exploration)
            KnowledgeType.SIZE -> context.getString(R.string.knowledge_size)
            KnowledgeType.FANATISM -> context.getString(R.string.knowledge_fanatism)
            KnowledgeType.GROZ_PAT -> context.getString(R.string.knowledge_groz_pat)
            KnowledgeType.MAN_HIP -> context.getString(R.string.knowledge_man_hip)
            KnowledgeType.RELIGION -> context.getString(R.string.knowledge_religion)
            KnowledgeType.CRUSADE -> context.getString(R.string.knowledge_crusade)
            KnowledgeType.METAL -> context.getString(R.string.knowledge_metal)
            KnowledgeType.MACE -> context.getString(R.string.knowledge_mace)
            KnowledgeType.RAPACITY -> context.getString(R.string.knowledge_rapacity)
            KnowledgeType.TERROR -> context.getString(R.string.knowledge_terror)
            KnowledgeType.RUNES -> context.getString(R.string.knowledge_runes)
            KnowledgeType.IGNEOUS_SMOKE -> context.getString(R.string.knowledge_igneous_smoke)
            KnowledgeType.DREAM_SMOKE -> context.getString(R.string.knowledge_dream_smoke)
            KnowledgeType.BROWN_SMOKE -> context.getString(R.string.knowledge_brown_smoke)
            KnowledgeType.PURPLE_SMOKE -> context.getString(R.string.knowledge_purple_smoke)
        }
}