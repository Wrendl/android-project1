package com.example.app1

fun cinemaList(): ArrayList<Cinema> {
    val list1 = ArrayList<Cinema>()
    val c1 = Cinema(R.drawable.c1, "Cinemax (Dostyk Plaza) Dolby Atmos", "г. Алматы, Самал-2, д. 111, уг.ул. Жолдасбекова, ТРЦ «Достык Плаза»")
    val c2 = Cinema(R.drawable.c2,"Lumiera Cinema (ЦУМ)", "г. Алматы, пр. Абылай хана, 62, «Арбат»")
    val c3 = Cinema(R.drawable.c3,"Chaplin MEGA Park (ул. Макатаева)", "г. Алматы, ул. Макатаева, 127, 3-й этаж")
    val c4 = Cinema(R.drawable.c4,"Kinopark 11 (Есентай) IMAX", "г. Алматы, пр. Аль-Фараби, 77/8, ТЦ «Esentai Mall»")
    list1.add(c1)
    list1.add(c2)
    list1.add(c3)
    list1.add(c4)
    return list1
}

fun filmList(): ArrayList<Film> {
    val list1 = ArrayList<Film>()
    val film = Film(R.drawable.c1, "Film", "cool", "comedy", 2, listOf("asd", "asd"), 2.8, "16+")
    val film1 = Film(R.drawable.c1, "Film 1", "cool", "comedy", 2, listOf("asd", "asd"), 2.8, "16+")
    list1.add(film)
    list1.add(film1)
    return list1
}