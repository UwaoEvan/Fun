package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superhero.model.Hero
import androidx.compose.ui.unit.dp
import com.example.superhero.ui.theme.Shapes

@Composable
fun HeroList(
    heroes: List<Hero>,
    contentPadding: PaddingValues
) {
    LazyColumn(){
        items(heroes) { hero ->
            HeroItem(
                hero = hero,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            )
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clip(shape = Shapes.medium)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            HeroInformation(hero = hero)
            Spacer(modifier = Modifier.weight(1f))
            HeroImage(hero = hero)
        }
    }
}

@Composable
fun HeroInformation(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroImage(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .size(72.dp)
        .clip(Shapes.medium)) {
        Image(
            painter = painterResource(hero.imageRes),
            contentDescription = stringResource(hero.nameRes)
        )
    }
}