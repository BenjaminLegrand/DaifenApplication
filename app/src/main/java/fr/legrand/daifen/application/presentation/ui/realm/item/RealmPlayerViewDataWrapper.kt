package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.RealmPlayer
import fr.legrand.daifen.application.data.values.RaceType

data class RealmPlayerViewDataWrapper(
    private val realmPlayer: RealmPlayer
) {
    fun getName() = realmPlayer.name

    fun getClan(context: Context): String = if (realmPlayer.clan.isBlank()) {
        context.getString(R.string.no_clan)
    } else {
        realmPlayer.clan
    }

    fun getRaceSecondaryText(context: Context): String = context.getString(
        R.string.player_race_secondary_format,
        when (realmPlayer.race) {
            RaceType.DWARF -> context.getString(R.string.race_dwarf)
            RaceType.UNDEAD -> context.getString(R.string.race_undead)
            RaceType.HUMAN -> context.getString(R.string.race_human)
            RaceType.NELRK -> context.getString(R.string.race_nelrk)
            RaceType.ELF -> context.getString(R.string.race_elf)
            RaceType.ORC -> context.getString(R.string.race_orc)
            RaceType.PRIMOTAURE -> context.getString(R.string.race_primotaure)
        }
    )
}