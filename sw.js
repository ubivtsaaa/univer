
self.addEventListener('install', event => {
  event.waitUntil(
    caches.open('pwa-card-v1').then(cache => {
      return cache.addAll([
        '/',
        '/index.html',
        '/styles.css',
        '/app.js',
        '/manifest.json',
        '/offline.html',
        '/images/yaa.jpeg',
        '/images/phone.jpg',
        '/images/tg.jpg',
        '/images/vk.jpg',
        '/icons/yaa.jpeg',
        '/icons/yaa.jpeg'
      ]);
    })
  );
});

self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request).then(response => response || fetch(event.request).catch(() => caches.match('/offline.html')))
  );
});
