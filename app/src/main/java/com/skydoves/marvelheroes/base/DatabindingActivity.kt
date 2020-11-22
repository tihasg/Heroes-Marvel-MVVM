package com.skydoves.marvelheroes.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
* DatabindingActivity é uma classe abstrata para fornecer [DataBindingUtil].
* fornece implementações de apenas [ViewDataBinding] de uma informação abstrata.
* Não modifique esta classe. Esta é uma classe de abstração de primeiro nível.
* Se você quiser adicionar mais especificações, faça outra classe que estenda [DatabindingActivity].
*/

abstract class DatabindingActivity : AppCompatActivity() {

  protected inline fun <reified T : ViewDataBinding> binding(
    @LayoutRes resId: Int
  ): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }
}
