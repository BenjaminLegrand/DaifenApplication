package fr.legrand.daifen.application.presentation.ui.fight.detail.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.player.item.PlayerViewDataWrapper
import kotlinx.android.synthetic.main.view_fight_detail_attacker.view.*

class FightDetailAttackerView(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_fight_detail_attacker, this)
    }

    fun bindItem(item: PlayerViewDataWrapper) {
        view_fight_detail_attacker_name.text = item.getName()

        Glide.with(this).load(item.getImageUrl())
            .error(Glide.with(this).load(R.drawable.daifen_login_logo))
            .apply(RequestOptions.circleCropTransform())
            .into(view_fight_detail_attacker_image)
    }
}