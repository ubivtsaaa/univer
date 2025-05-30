
function showQR(type) {
  const qr = document.getElementById("qr-image");
  qr.src = `images/${type}.jpg`;
  qr.style.display = "block";
}

if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('sw.js')
    .then(() => console.log("Service Worker зарегистрирован"))
    .catch(err => console.error("SW ошибка", err));
}
