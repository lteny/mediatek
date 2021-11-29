<template>
      <div>
        <b-carousel
          id="carousel-1"
          v-model="slide"
          :interval="4000"
          controls
          indicators
          background="#ababab"
          img-width="1024"
          img-height="250"
          style="text-shadow: 1px 1px 2px #333;"
          @sliding-start="onSlideStart"
          @sliding-end="onSlideEnd"
        >
          <!-- Text slides with image -->
          <b-carousel-slide
            caption="Первое изображение"
            text="Некий текст......"
            img-src="https://picsum.photos/1024/250/?image=52"
           ></b-carousel-slide>

          <b-carousel-slide
            caption="Второе изображение"
            text="Некий текст......"
            img-src="https://picsum.photos/1024/250/?image=52"
          ></b-carousel-slide>

          <b-carousel-slide
            caption="Третье изображение"
            text="Некий текст......"
            img-src="https://picsum.photos/1024/250/?image=52"
          ></b-carousel-slide>
        </b-carousel>
      </div>
</template>

<script>
export default {
  name: "Carousel",
  data() {
    return {
      slide: 0,
      sliding: null
    }
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true
    },
    onSlideEnd(slide) {
      this.sliding = false
    }
  }
}
</script>

<style scoped>

</style>
