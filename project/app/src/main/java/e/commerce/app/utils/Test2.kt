package e.commerce.app.utils

import android.util.Patterns
import androidx.core.util.PatternsCompat


fun CharSequence?.isValidEmail() = !isNullOrEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()


