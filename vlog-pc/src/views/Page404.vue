<template>
  <div class="box">
    <!-- error -->
    <section class="w3l-error-9">
      <div class="error-page">
        <div class="wrapper-full">
          <div class="main-content">
            <h2>Sorry</h2>
            <h4>Looks like you're lost...</h4>
            <p>You can either return to the previous page, visit our homepage or contact our support team.</p>
            <!-- buttons -->
            <div class="buttons">
              <a href="index.html" class="btn brk-btn-bg brk-btn"> Go to Homepage </a>
              <a href="#contact" class="btn brk-btn"> Contact Us </a>
            </div>
          </div>
          <div class="bottom-header">
            <!-- copyright -->
            <div class="copyrights text-center">
              <p>© 2020 Pug Error Page. All rights reserved | Design by <a href="http://.com/" target="_blank"></a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- <div class="copyrights" id="links20210126">
      Collect from <a href="#">*******</a>
      <a href="#">*******</a>
    </div> -->
  </div>
</template>

<script>
export default {
  name: 'Page404',
}
</script>

<style scoped>
.copyrights {
  text-indent: -9999px;
  height: 0;
  line-height: 0;
  font-size: 0;
  overflow: hidden;
}
/*--
Author: 
Author URL: http://.com
--*/
/* reset code */

.box {
  margin: 0;
  padding: 0;
  color: #585858;
  scroll-behavior: smooth;
}

* {
  box-sizing: border-box;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen-Sans, Ubuntu, Cantarell, 'Helvetica Neue',
    sans-serif;
}

.wrapper-full {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

.wrapper {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

@media (min-width: 576px) {
  .wrapper {
    max-width: 540px;
  }
}

@media (min-width: 768px) {
  .wrapper {
    max-width: 720px;
  }
}

@media (min-width: 992px) {
  .wrapper {
    max-width: 960px;
  }
}

@media (min-width: 1200px) {
  .wrapper {
    max-width: 1140px;
  }
}

.img-responsive {
  max-width: 100%;
  display: block;
}

.img-fluid {
  width: 100%;
}

.d-grid {
  display: grid;
}

.d-flex {
  display: flex;
  display: -webkit-flex;
  flex-wrap: wrap;
}

.text-center {
  text-align: center;
}

.text-left {
  text-align: left;
}

.text-right {
  text-align: right;
}

button,
input,
select {
  -webkit-appearance: none;
  outline: none;
}

button,
.btn,
select {
  cursor: pointer;
}

a {
  text-decoration: none;
}

iframe {
  border: none;
}

h1,
h2,
h3,
h4,
h5,
h6,
p,
ul,
ol {
  margin: 0;
  padding: 0;
}

.p-relative {
  position: relative;
}

.p-absolute {
  position: absolute;
}

.p-fixed {
  position: fixed;
}

.p-sticky {
  position: -webkit-sticky;
  position: sticky;
}

body a:hover,
body button:hover {
  opacity: 0.8;
}

h1,
h2,
h3,
h4,
h5,
h6,
a {
  color: #050404;
}

p {
  color: #585858;
}

.brk-btn {
  position: relative;
  background: none;
  color: #fff;
  text-transform: uppercase;
  text-decoration: none;
  border: 2px solid #fff;
  padding: 10px 22px;
  font-size: 14px;
  display: inline-block;
  border-radius: 40px;
  transition: all 0.3s ease;
  -moz-transition: all 0.3s ease;
  -webkit-transition: all 0.3s ease;
  -ms-transition: all 0.3s ease;
  -o-transition: all 0.3s ease;
}

.brk-btn-bg {
  color: var(--title-color);
  background: #fff;
}

.brk-btn::before {
  content: '';
  display: block;
  position: absolute;
  width: 10%;
  background: #222;
  height: 0.2em;
  right: 20%;
  top: -0.21em;
  transform: skewX(-45deg);
  -webkit-transition: all 0.45s cubic-bezier(0.86, 0, 0.07, 1);
  transition: all 0.45s cubic-bezier(0.86, 0, 0.07, 1);
}

.brk-btn::after {
  content: '';
  display: block;
  position: absolute;
  width: 10%;
  background: #222;
  height: 0.2em;
  left: 20%;
  bottom: -0.21em;
  transform: skewX(45deg);
  -webkit-transition: all 0.45 cubic-bezier(0.86, 0, 0.07, 1);
  transition: all 0.45s cubic-bezier(0.86, 0, 0.07, 1);
}

.brk-btn:hover::before {
  right: 80%;
}

.brk-btn:hover::after {
  left: 80%;
}

/* reset code */

/* error */
.error-page {
  background: url('https://ossstored.oss-cn-shanghai.aliyuncs.com/bg/error.jpg') no-repeat top;
  background-size: cover;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  -ms-background-size: cover;
  position: relative;
  z-index: 0;
  min-height: 100vh;
  align-items: center;
  display: grid;
  /* padding: 20px 0; */
}

.main-content {
  text-align: center;
  padding-top: 18em;
}

.main-content h2 {
  color: #fff;
  font-size: 7em;
  text-transform: uppercase;
  font-weight: 100;
}

.main-content h4 {
  font-size: 25px;
  line-height: 25px;
  color: #eee;
  font-weight: 400;
}

.main-content p {
  font-size: 17px;
  line-height: 25px;
  color: #c5c5c5;
  margin-top: 15px;
  max-width: 550px;
  margin: 10px auto 0;
}

/* button */
.buttons {
  margin-top: 2em;
}

/* logo & copyright */
.bottom-header {
  grid-template-columns: 1fr 1fr;
  margin-top: 7.5em;
  align-items: center;
}

.bottom-header .logo {
  color: #fff;
  font-size: 30px;
}

.copyrights p {
  color: #d2d2d2;
  font-size: 15px;
}

.copyrights p a {
  color: #fff;
}

/*-- responsive design --*/
@media (max-width: 1440px) {
  .main-content h2 {
    font-size: 6em;
  }

  .main-content {
    padding-top: 15em;
  }

  .bottom-header {
    margin-top: 6.5em;
  }
}

@media (max-width: 1280px) {
  .main-content {
    padding-top: 13em;
  }

  .main-content h2 {
    font-size: 5.5em;
  }
}

@media (max-width: 736px) {
  .main-content {
    padding-top: 11em;
  }

  .main-content h2 {
    font-size: 4.5em;
  }
}

@media (max-width: 500px) {
  .copyrights p {
    line-height: 22px;
  }

  .bottom-header {
    grid-template-columns: 1fr;
    text-align: center;
    grid-gap: 10px;
  }

  .copyrights p {
    text-align: center;
  }
}

@media (max-width: 375px) {
  .main-content h2 {
    font-size: 4em;
  }
}

@media (max-width: 320px) {
  .brk-btn {
    padding: 10px 18px;
    font-size: 13px;
  }
}
/*-- //responsive design --*/
</style>