package com.example.musicalgroups.data

object DataGenerator {

    private val discos: MutableList<Album> = mutableListOf()

    init {
        addDisc(discos)
    }

    fun addArtist(artist: MutableList<Artista>) {
        artist.add(Artista("ColdPlay", 0,"src_coldplay_logo"))
        artist.add(Artista("The Offspring", 0,"src_offspring_logo"))
        artist.add(Artista("Papa Roach", 0,"src_paparoach_logo"))
        artist.add(Artista("Red Hot Chili Peppers", 0,"src_redhotchili_logo"))
    }

    fun addDisc(disks: MutableList<Album>) {
        disks.add(Album("Parachutes", "ColdPlay", "Capitol Records", 2000, 0,"img_parachute"))
        disks.add(Album("A Rush of Blood to the Head", "ColdPlay", "Capitol Records", 2002, 0,"img_arushofbloo"))
        disks.add(Album("X&Y", "ColdPlay", "Capitol Records", 2008, 0,"img_xy"))
        disks.add(Album("Mylo Xyloto", "ColdPlay", "Capitol Records", 2011, 0,"img_myloxyloto"))
        disks.add(Album("Ghost Stories", "ColdPlay", "Parlophone", 2014, 0,"src_ghost_stories"))
        disks.add(Album("Everyday Life", "ColdPlay", "Parlophone", 2021, 0,"img_everydaylife"))

        disks.add(Album("Californication", "Red Hot Chili Peppers", "Warner", 1999, 0,"img_californication"))
        disks.add(Album("By the way", "Red Hot Chili Peppers", "Warner", 2002, 0,"img_bytheway"))
        disks.add(Album("Stadium Arcadium", "Red Hot Chili Peppers", "Warner", 2006, 0,"img_stadiumarcadium"))
        disks.add(Album("I'm with You", "Red Hot Chili Peppers", "Warrner", 2011, 0,"img_imwithyou"))
        disks.add(Album("The Getaway", "Red Hot Chili Peppers", "Warrner", 2016, 0,"img_thegetaway"))
        disks.add(Album("Unlimited Love", "Red Hot Chili Peppers", "Warrner", 2022, 0,"img_unlimitedlove"))

        disks.add(Album("Smash", "The Offspring", "Epitaph Records", 1994, 0,"img_smash"))
        disks.add(Album("Ixnay on the Hombre", "The Offspring", "Columbia Records", 1997, 0,"img_ixnayonthehombre"))
        disks.add(Album("Americana", "The Offspring", "Columbia Records", 1998, 0,"img_americana"))
        disks.add(Album("Splinter", "The Offspring", "Columbia Records", 2003, 0,"img_splinter"))
        disks.add(Album("Rise and Fall, Rage and Grace", "The Offspring", "Columbia Records", 2008, 0,"img_riseandfall"))
        disks.add(Album("Days Go By", "The Offspring", "Columbia Records", 2012, 0,"img_daysgoby"))
        disks.add(Album("Let the Bad Times Roll", "The Offspring", "Concord Records", 2021, 0,"img_letthebadtimesroll"))

        disks.add(Album("Infest", "Papa Roach", "DreamWorks Records", 2000, 0,"img_infest"))
        disks.add(Album("Lovehatetragedy", "Papa Roach", "DreamWorks Records", 2002, 0,"img_lovehatetragedy"))
        disks.add(Album("Getting Away With Murder", "Papa Roach", "Geffen Records", 2004, 0,"img_gettingaway"))
        disks.add(Album("The Paramour Sessions", "Papa Roach", "Geffen Records", 2006, 0,"img_theparamoursessions"))
        disks.add(Album("Metamorphosis", "Papa Roach", "Interscope Records", 2009, 0,"img_metamorphosis"))
        disks.add(Album("The Connection", "Papa Roach", "Eleven Seven Music", 2012, 0,"img_theconnection"))
        disks.add(Album("F.E.A.R.", "Papa Roach", "Eleven Seven Music", 2015, 0,"img_fear"))
        disks.add(Album("Crooked Teeth", "Papa Roach", "Eleven Seven Music", 2017, 0,"img_crookedteeth"))
    }

    fun getAlbums(artista: Artista): List<Album> {
        return discos.filter { it.artista == artista.nombre }
    }

    fun getDetailAlbum(disco: Album): List<Album> {
        return discos.filter { it.titulo == disco.titulo }
    }
}
