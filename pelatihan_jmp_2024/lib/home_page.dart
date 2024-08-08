import 'package:flutter/material.dart';
import 'package:pelatihan_jmp_2024/auth/login.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.of(context).pushAndRemoveUntil(
              MaterialPageRoute(builder: (BuildContext context) => LoginPage()),
              (Route<dynamic> route) => false);
        },
        child: Icon(Icons.logout_rounded),
        backgroundColor: Color(0xff0500FE),
      ),
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Image.network(
                "https://cdn-1.timesmedia.co.id/images/2022/09/17/pantai-papuma-jember.jpg",
                fit: BoxFit.cover,
              ),
              SizedBox(height: 20),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 20),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Pantai Papuma',
                          style: TextStyle(
                            fontWeight: FontWeight.w700,
                            fontSize: 15,
                          ),
                        ),
                        SizedBox(height: 2),
                        Text(
                          'Jember, Jawa Timur',
                          style: TextStyle(
                            fontWeight: FontWeight.w300,
                            fontSize: 12,
                          ),
                        ),
                      ],
                    ),
                    // Spacer(),
                    // Icon(Icons.favorite, color: Colors.red),
                    // SizedBox(width: 2),
                    // Text('4.3')
                    Row(
                      children: [
                        Icon(Icons.favorite, color: Colors.red),
                        SizedBox(width: 2),
                        Text(
                          '4.3',
                          style: TextStyle(
                            fontSize: 16,
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
              SizedBox(height: 20),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 20),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Column(
                      children: [
                        Icon(
                          Icons.phone,
                          color: Color(0xff0500FE),
                          size: 30,
                        ),
                        SizedBox(height: 10),
                        Text(
                          'CALL',
                          style: TextStyle(
                            color: Color(0xff0500FE),
                            fontSize: 12,
                          ),
                        ),
                      ],
                    ),
                    Column(
                      children: [
                        Icon(
                          Icons.navigation,
                          color: Color(0xff0500FE),
                          size: 30,
                        ),
                        SizedBox(height: 10),
                        Text(
                          'ROUTE',
                          style: TextStyle(
                            color: Color(0xff0500FE),
                            fontSize: 12,
                          ),
                        ),
                      ],
                    ),
                    Column(
                      children: [
                        Icon(
                          Icons.share,
                          color: Color(0xff0500FE),
                          size: 30,
                        ),
                        SizedBox(height: 10),
                        Text(
                          'SHARE',
                          style: TextStyle(
                            color: Color(0xff0500FE),
                            fontSize: 12,
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
              SizedBox(height: 20),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 20),
                child: Column(
                  children: [
                    Text(
                      'Pantai Papuma adalah sebuah pantai yang menjadi tempat wisata di Kabupaten Jember,Provinsi Jawa Timur, Indonesia.  Nama Papuma sendiri sebenarnya adalah sebuah singkatan  dari “Pasir Putih Malikan. Pantai papuma berada di Desa Lojejer,  Kecamatan  uluhan, Kabupaten Jember. Pantai papuma adalah salah satu pantai yang cukup populer dan terkenal di Jember. Walaupun jarak sekitar 40 kilometer cukup jauh dari pusat kota Jember. Namun, keindahan pasir putih Malikan ini cukup eksotis dan mampu menarik perhatian wisatawan lokal hingga mancanegara untuk datang kesana.',
                      style: TextStyle(fontSize: 12),
                      textAlign: TextAlign.justify,
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    Text(
                      'Pantai Papuma mulai dibuka secara resmi sejak tahun 1994, namun pada tahun 1998 wisata pantai di Jember yang ini baru mulai ramai dikunjungi oleh wisatawan. Menurut sejarah, dulu pada zaman penjajahan Jepang hutan yang ada di sekitar pantai Papuma ini dijadikan sebagai markas dan benteng Jepang ketika perang.',
                      style: TextStyle(fontSize: 12),
                      textAlign: TextAlign.justify,
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
