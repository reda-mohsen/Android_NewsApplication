package com.example.newsappinkotlin.db
import androidx.room.*
import com.example.newsappinkotlin.Model.News


@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (article: List<News>)

    @Query("SELECT * FROM News")
    fun getAllNews(): List<News>

    @Delete
    suspend fun deleteArticle(article:News)
}