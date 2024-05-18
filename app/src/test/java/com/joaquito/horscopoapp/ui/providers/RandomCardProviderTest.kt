package com.joaquito.horscopoapp.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should return a random card`(){
        val randomCard = RandomCardProvider()
        val card = randomCard.getRandomCard()
        //assert = if pero de testing.
        assertNotNull(card)
    }
}