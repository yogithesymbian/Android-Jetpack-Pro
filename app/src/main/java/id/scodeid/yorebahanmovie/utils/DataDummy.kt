package id.scodeid.yorebahanmovie.utils

import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.data.source.local.entity.*
import id.scodeid.yorebahanmovie.data.source.remote.response.*

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val arrListMovie = ArrayList<MovieEntity>()
        arrListMovie.add(
            MovieEntity(
                "1",
                false,
                R.drawable.poster_t34,
                "T-34 (2018)",
                "12+",
                "01/01/2019",
                "(RU) Kejahatan, Aksi, Drama, Sejarah",
                "2h 19m",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "\$10",
                "69",
                "Rilis",
                "Alexey Sidorov",
                "Rusia",
                "\$8,000,000.00",
                "\$36,220,872.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "2",
                false,
                R.drawable.poster_spiderman,
                "Spider-Man: Into the Spider-Verse (2018)",
                "PG",
                "12/14/2018",
                "Aksi, Petualangan, Animasi, Cerita Fiksi, Komedi",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "\$12",
                "84",
                "Rilis",
                "Rodney Rothman",
                "Inggris",
                "\$90,000,000.00",
                "\$375,540,831.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "3",
                false,
                R.drawable.poster_robin_hood,
                "Robin Hood (2018)",
                "PG-13",
                "21/11/2018",
                "Petualangan, Aksi, Cerita Seru",
                "1h 56m",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "\$11",
                "59",
                "Rilis",
                "-",
                "Inggris",
                "\$100,000,000.00",
                "\$86,493,046.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "4",
                false,
                R.drawable.poster_overlord,
                "Overlord (2018)",
                "R",
                "09/11/2018",
                "Kengerian, Kejahatan, Cerita Fiksi",
                "1h 50m",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "\$9",
                "69",
                "Rilis",
                "Julius Averyf",
                "Inggris",
                "\$38,000,000.00",
                "\$41,657,844.00",
                true
            )
        )
        arrListMovie.add(
            MovieEntity(
                "5",
                false,
                R.drawable.poster_infinity_war,
                "Avengers: Infinity War (2018)",
                "PG 13",
                "27/04/2018",
                "Petualangan, Aksi, Cerita Fiksi",
                "2h 29m",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "\$13",
                "83",
                "Rilis",
                "Anthony Russo",
                "Inggris",
                "\$300,000,000.00",
                "\$2,046,239,637.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "6",
                false,
                R.drawable.poster_aquaman,
                "Aquaman (2018)",
                "PG-13",
                "21/12/2018",
                "Aksi, Petualangan, Fantasi",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "\$8",
                "69",
                "Rilis",
                "James Wan",
                "Inggris",
                "\$160,000,000.00",
                "\$1,148,461,807.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "7",
                false,
                R.drawable.poster_master_z,
                "Master Z: Ip Man Legacy (2018)",
                "PG-13",
                "26/12/2018",
                "Aksi",
                "1h 47m",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "\$8",
                "60",
                "Rilis",
                "Yuen Woo-ping",
                "Inggris",
                "\$-",
                "\$21,832,649.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "8",
                false,
                R.drawable.poster_serenity,
                "Serenity (2019)",
                "R",
                "25/01/2019",
                "Cerita Seru, Misteri, Drama",
                "1h 42m",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "\$9",
                "54",
                "Rilis",
                "Steven Knight",
                "Inggris",
                "\$25,000,000.00",
                "\$214,454,622.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "9",
                false,
                R.drawable.poster_mortal_engines,
                "Mortal Engines (2018)",
                "PG-13",
                "14/12/2018",
                "Petualangan, Cerita Fiksi",
                "2h 9m",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "\$7",
                "61",
                "Rilis",
                "Christian Rivers",
                "Inggris",
                "\$100,000,000.00",
                "\$83,672,673.00",
                false
            )
        )
        arrListMovie.add(
            MovieEntity(
                "10",
                false,
                R.drawable.poster_cold_persuit,
                "Cold Pursuit (2019)",
                "R",
                "08/02/2019",
                "Aksi, Kejahatan, Cerita Seru",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "\$7",
                "57",
                "Rilis",
                "Hans Petter Moland",
                "Inggris",
                "\$60,000,000.00",
                "\$76,419,755.00",
                true
            )
        )
        return arrListMovie
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val arrListTvShow = ArrayList<TvShowEntity>()

        arrListTvShow.add(
            TvShowEntity(
                "a1",
                false,
                R.drawable.poster_ncis,
                "NCIS (2003)",
                "TV-14",
                "-",
                "Kejahatan, Aksi & Petualangan, Drama",
                "45m",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "\$7",
                "74",
                "Berlanjut",
                "Donald P. Bellisario",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a2",
                false,
                R.drawable.poster_supergirl,
                "Supergirl (2015)",
                "TV-14",
                "01/01/2019",
                "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
                "42m",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "\$10",
                "73",
                "Berlanjut",
                "Greg Berlanti",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a3",
                false,
                R.drawable.poster_shameless,
                "Shameless (2011)",
                "TV-MA",
                "Desember 6, 2020.",
                "Drama, Komedi",
                "57m",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "\$8",
                "80",
                "Berakhir",
                "John Wells",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a4",
                false,
                R.drawable.poster_grey_anatomy,
                "Grey's Anatomy (2005)",
                "TV-14",
                "01/01/2019",
                "Drama",
                "43m",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "\$10",
                "82",
                "Berlanjut",
                "Shonda Rhimes",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a5",
                false,
                R.drawable.poster_gotham,
                "Gotham (2014)",
                "TV-14",
                "Januari 3, 2019",
                "Drama, Kejahatan, Sci-fi & Fantasy",
                "43m",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "\$4",
                "75",
                "Berlanjut",
                "Bruno Heller",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a6",
                false,
                R.drawable.poster_iron_fist,
                "Marvel's Iron Fist (2017)",
                "TV-MA",
                "September 7, 2018.",
                "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                "55m",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "\$7",
                "66",
                "Dibatalkan",
                "Scott Buck",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a7",
                false,
                R.drawable.poster_riverdale,
                "Riverdale (2017)",
                "TV-14",
                "Januari 20, 2021.",
                "Misteri, Drama, Kejahatan",
                "45m",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "\$10",
                "73",
                "Berlanjut",
                "Roberto Aguirre-Sacasa",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a8",
                false,
                R.drawable.poster_supernatural,
                "Supernatural (2005)",
                "TV-14",
                "Oktober 10, 2019",
                "Drama, Misteri, Sci-fi & Fantasy",
                "45m",
                "Dua bersaudara mencari ayah mereka yang hilang, pria yang melatih mereka untuk menjadi prajurit melawan kejahatan supernatural",
                "\$10",
                "82",
                "Berakhir",
                "Eric Kripke",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a9",
                false,
                R.drawable.poster_family_guy,
                "Family Guy (1999)",
                "TV-14",
                "September 27, 2020",
                "Animasi, Komedi",
                "22m",
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "\$10",
                "70",
                "Berlanjut",
                "Seth MacFarlane",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowEntity(
                "a10",
                false,
                R.drawable.poster_naruto_shipudden,
                "ナルト 疾風伝 (2007)",
                "TV-14",
                "Mei 27, 2015.",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                "25m",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "\$8",
                "86",
                "Berakhir",
                "-",
                "Berakhir",
                "Scripted",
                false
            )
        )

        return arrListTvShow
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val arrListMovie = ArrayList<MovieResponse>()
        arrListMovie.add(
            MovieResponse(
                "1",
                false,
                R.drawable.poster_t34,
                "T-34 (2018)",
                "12+",
                "01/01/2019",
                "(RU) Kejahatan, Aksi, Drama, Sejarah",
                "2h 19m",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "\$10",
                "69",
                "Rilis",
                "Alexey Sidorov",
                "Rusia",
                "\$8,000,000.00",
                "\$36,220,872.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "2",
                false,
                R.drawable.poster_spiderman,
                "Spider-Man: Into the Spider-Verse (2018)",
                "PG",
                "12/14/2018",
                "Aksi, Petualangan, Animasi, Cerita Fiksi, Komedi",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "\$12",
                "84",
                "Rilis",
                "Rodney Rothman",
                "Inggris",
                "\$90,000,000.00",
                "\$375,540,831.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "3",
                false,
                R.drawable.poster_robin_hood,
                "Robin Hood (2018)",
                "PG-13",
                "21/11/2018",
                "Petualangan, Aksi, Cerita Seru",
                "1h 56m",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "\$11",
                "59",
                "Rilis",
                "-",
                "Inggris",
                "\$100,000,000.00",
                "\$86,493,046.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "4",
                false,
                R.drawable.poster_overlord,
                "Overlord (2018)",
                "R",
                "09/11/2018",
                "Kengerian, Kejahatan, Cerita Fiksi",
                "1h 50m",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "\$9",
                "69",
                "Rilis",
                "Julius Averyf",
                "Inggris",
                "\$38,000,000.00",
                "\$41,657,844.00",
                true
            )
        )
        arrListMovie.add(
            MovieResponse(
                "5",
                false,
                R.drawable.poster_infinity_war,
                "Avengers: Infinity War (2018)",
                "PG 13",
                "27/04/2018",
                "Petualangan, Aksi, Cerita Fiksi",
                "2h 29m",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "\$13",
                "83",
                "Rilis",
                "Anthony Russo",
                "Inggris",
                "\$300,000,000.00",
                "\$2,046,239,637.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "6",
                false,
                R.drawable.poster_aquaman,
                "Aquaman (2018)",
                "PG-13",
                "21/12/2018",
                "Aksi, Petualangan, Fantasi",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "\$8",
                "69",
                "Rilis",
                "James Wan",
                "Inggris",
                "\$160,000,000.00",
                "\$1,148,461,807.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "7",
                false,
                R.drawable.poster_master_z,
                "Master Z: Ip Man Legacy (2018)",
                "PG-13",
                "26/12/2018",
                "Aksi",
                "1h 47m",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "\$8",
                "60",
                "Rilis",
                "Yuen Woo-ping",
                "Inggris",
                "\$-",
                "\$21,832,649.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "8",
                false,
                R.drawable.poster_serenity,
                "Serenity (2019)",
                "R",
                "25/01/2019",
                "Cerita Seru, Misteri, Drama",
                "1h 42m",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "\$9",
                "54",
                "Rilis",
                "Steven Knight",
                "Inggris",
                "\$25,000,000.00",
                "\$214,454,622.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "9",
                false,
                R.drawable.poster_mortal_engines,
                "Mortal Engines (2018)",
                "PG-13",
                "14/12/2018",
                "Petualangan, Cerita Fiksi",
                "2h 9m",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "\$7",
                "61",
                "Rilis",
                "Christian Rivers",
                "Inggris",
                "\$100,000,000.00",
                "\$83,672,673.00",
                false
            )
        )
        arrListMovie.add(
            MovieResponse(
                "10",
                false,
                R.drawable.poster_cold_persuit,
                "Cold Pursuit (2019)",
                "R",
                "08/02/2019",
                "Aksi, Kejahatan, Cerita Seru",
                "1h 59m",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "\$7",
                "57",
                "Rilis",
                "Hans Petter Moland",
                "Inggris",
                "\$60,000,000.00",
                "\$76,419,755.00",
                true
            )
        )
        return arrListMovie
    }

    fun generateRemoteDummyTvShow(): List<TvShowResponse> {
        val arrListTvShow = ArrayList<TvShowResponse>()

        arrListTvShow.add(
            TvShowResponse(
                "a1",
                false,
                R.drawable.poster_ncis,
                "NCIS (2003)",
                "TV-14",
                "-",
                "Kejahatan, Aksi & Petualangan, Drama",
                "45m",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "\$7",
                "74",
                "Berlanjut",
                "Donald P. Bellisario",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a2",
                false,
                R.drawable.poster_supergirl,
                "Supergirl (2015)",
                "TV-14",
                "01/01/2019",
                "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
                "42m",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "\$10",
                "73",
                "Berlanjut",
                "Greg Berlanti",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a3",
                false,
                R.drawable.poster_shameless,
                "Shameless (2011)",
                "TV-MA",
                "Desember 6, 2020.",
                "Drama, Komedi",
                "57m",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "\$8",
                "80",
                "Berakhir",
                "John Wells",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a4",
                false,
                R.drawable.poster_grey_anatomy,
                "Grey's Anatomy (2005)",
                "TV-14",
                "01/01/2019",
                "Drama",
                "43m",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "\$10",
                "82",
                "Berlanjut",
                "Shonda Rhimes",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a5",
                false,
                R.drawable.poster_gotham,
                "Gotham (2014)",
                "TV-14",
                "Januari 3, 2019",
                "Drama, Kejahatan, Sci-fi & Fantasy",
                "43m",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "\$4",
                "75",
                "Berlanjut",
                "Bruno Heller",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a6",
                false,
                R.drawable.poster_iron_fist,
                "Marvel's Iron Fist (2017)",
                "TV-MA",
                "September 7, 2018.",
                "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                "55m",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "\$7",
                "66",
                "Dibatalkan",
                "Scott Buck",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a7",
                false,
                R.drawable.poster_riverdale,
                "Riverdale (2017)",
                "TV-14",
                "Januari 20, 2021.",
                "Misteri, Drama, Kejahatan",
                "45m",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "\$10",
                "73",
                "Berlanjut",
                "Roberto Aguirre-Sacasa",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a8",
                false,
                R.drawable.poster_supernatural,
                "Supernatural (2005)",
                "TV-14",
                "Oktober 10, 2019",
                "Drama, Misteri, Sci-fi & Fantasy",
                "45m",
                "Dua bersaudara mencari ayah mereka yang hilang, pria yang melatih mereka untuk menjadi prajurit melawan kejahatan supernatural",
                "\$10",
                "82",
                "Berakhir",
                "Eric Kripke",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a9",
                false,
                R.drawable.poster_family_guy,
                "Family Guy (1999)",
                "TV-14",
                "September 27, 2020",
                "Animasi, Komedi",
                "22m",
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "\$10",
                "70",
                "Berlanjut",
                "Seth MacFarlane",
                "Inggris",
                "Scripted",
                false
            )
        )
        arrListTvShow.add(
            TvShowResponse(
                "a10",
                false,
                R.drawable.poster_naruto_shipudden,
                "ナルト 疾風伝 (2007)",
                "TV-14",
                "Mei 27, 2015.",
                "Animasi, Aksi & Petualangan, Sci-fi & Fantasy",
                "25m",
                "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                "\$8",
                "86",
                "Berakhir",
                "-",
                "Berakhir",
                "Scripted",
                false
            )
        )

        return arrListTvShow
    }


}