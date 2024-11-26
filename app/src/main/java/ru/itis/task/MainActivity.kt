package ru.itis.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Пример
        val meme = Meme(id = 1, name = "Мем с котиком", imageUrl = "https://example.com/cat.jpg", emotion = "радость")
        val regularMeme = RegularMeme(meme)

        // Scope функция
        with(regularMeme) {
            like()
            saveToGallery()
        }

        val rareMeme = RareMeme(meme)
        println(rareMeme.getRarityInfo())
    }

    data class Meme(
        val id: Int,
        val name: String?,
        val imageUrl: String,
        var isLiked: Boolean = false,
        var emotion: String,
    ) {
        // Extension-свойство
        val nameLength: Int
            get() = name?.length ?: 0

        // Extension-функция
        fun changeEmotion(newEmotion: String) {
            emotion = newEmotion
            println("Эмоция изменена на: $emotion")
        }
    }

    interface MemeActions {
        fun like()
        fun dislike()
        fun saveToGallery()
        fun addEmotion(newEmotion: String)
    }

    // Класс-наследник
    class RegularMeme(private val meme: Meme) : MemeActions {
        override fun like() {
            meme.isLiked = true
            println("Вам понравился ${meme.name}!")
        }

        // Переопределение методов
        override fun dislike() {
            meme.isLiked = false
            println("${meme.name} пропущен!")
        }

        override fun saveToGallery() {
            if (meme.isLiked) {
                println("${meme.name} сохранен в галерию!")
            } else {
                println("Ты можешь сохранить только понравившиеся мемы!")
            }
        }

        override fun addEmotion(newEmotion: String) {
            meme.changeEmotion(newEmotion)
        }
    }

    class RareMeme(private val meme: Meme) : MemeActions {
        private val rarity = "Редкий"

        override fun like() {
            meme.isLiked = true
            println("${meme.name} теперь в коллекции редких мемов!")
        }

        override fun dislike() {
            meme.isLiked = false
            println("${meme.name} удалён из коллекции редких мемов.")
        }

        override fun saveToGallery() {
            println("${meme.name} сохраняется в секретную галерею редких мемов.")
        }

        override fun addEmotion(newEmotion: String) {
            meme.changeEmotion(newEmotion)
        }

        fun getRarityInfo(): String {
            return "Мем '${meme.name}' имеет редкость: $rarity"
        }
    }

    sealed class MemeType {
        object Funny : MemeType()
        object Sad : MemeType()
        object Inspirational : MemeType()
    }

    inner class MemeCollection {
        private val memes = mutableListOf<Meme>()

        fun addMeme(meme: Meme) {
            memes.add(meme)
            println("Мем '${meme.name}' добавлен в коллекцию.")
        }

        fun listMemes() {
            memes.forEach { println(it) }
        }
    }

    object MemeManager {
        private val globalMemes = mutableListOf<Meme>()

        fun addGlobalMeme(meme: Meme) {
            globalMemes.add(meme)
            println("Мем '${meme.name}' добавлен в глобальный список.")
        }

        fun showGlobalMemes() {
            globalMemes.forEach { println(it) }
        }
    }
}
