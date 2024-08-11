package com.ar4uk.myapplication.domain.repository

import com.ar4uk.myapplication.domain.model.NetworkStatus
import kotlinx.coroutines.flow.StateFlow

interface NetworkConnectivityObserver {
    val networkStatus: StateFlow<NetworkStatus>
}