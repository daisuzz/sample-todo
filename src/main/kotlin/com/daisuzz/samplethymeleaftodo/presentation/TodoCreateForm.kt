package com.daisuzz.samplethymeleaftodo.presentation

import javax.validation.constraints.NotNull

data class TodoCreateForm(

        @field:NotNull
        val title: String? = null,


        @field:NotNull
        val detail: String? = null
)
