package com.ar4uk.myapplication.domain.repository

interface Downloader {
    fun downloadFile(url: String, fileName: String?)
}