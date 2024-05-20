# Android Uygulaması
Bu proje, Firebase Authentication ve Firebase Firestore kullanarak kullanıcıların giriş yapmasını ve kayıt olmasını sağlayan basit bir Android uygulamasıdır. 
Uygulama, üç temel aktivite içerir: Giriş Ekranı, Giriş (Login) ve Kayıt (Signup) aktiviteleri. Başarılı bir şekilde giriş yapan kullanıcılar, ana sayfaya yönlendirilir.

#Yapılandırma ve Kurulum

##Gereksinimler
Android Studio
Firebase hesabı
Firebase Authentication ve Firestore yapılandırması

##Firebase Yapılandırması

Firebase Console üzerinden yeni bir proje oluşturun.
Uygulamanızı Firebase projenize ekleyin. google-services.json dosyasını indirin ve Android projenizin app dizinine ekleyin.
Firebase Authentication'da E-posta/Şifre kimlik doğrulamasını etkinleştirin.
Firestore veritabanını etkinleştirin.

##Projenin İndirilmesi ve Çalıştırılması
Bu projeyi indirin veya klonlayın.
Android Studio'da projeyi açın.
google-services.json dosyasının doğru dizinde olduğundan emin olun.
Projeyi senkronize edin ve derleyin.
Uygulamayı cihazınızda veya emülatörde çalıştırın.

##Özellikler
Kullanıcı kaydı ve giriş işlemleri
Firebase Firestore'a kullanıcı bilgilerini kaydetme
Firebase Authentication ile kullanıcı doğrulaması
Kullanıcı giriş yapmışsa otomatik olarak ana ekrana yönlendirme

##Kullanım
Uygulamayı açtığınızda, giriş veya kayıt seçenekleri ile karşılaşacaksınız.
Eğer bir hesabınız varsa, giriş ekranına giderek e-posta ve şifrenizi girerek giriş yapabilirsiniz.
Eğer bir hesabınız yoksa, kayıt ekranına giderek gerekli bilgileri doldurarak yeni bir hesap oluşturabilirsiniz.
Başarılı giriş yaptıktan sonra ana ekrana yönlendirileceksiniz.
