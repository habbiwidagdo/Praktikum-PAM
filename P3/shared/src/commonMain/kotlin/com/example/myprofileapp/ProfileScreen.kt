package com.example.myprofileapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

// 1. Reusable Composable: ProfileHeader
@Composable
fun ProfileHeader(
    name: String,
    bio: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Placeholder Avatar berbentuk Lingkaran
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name.take(1),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = bio,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

// 2. Reusable Composable: InfoItem
@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// 3. Reusable Composable: ProfileCard
@Composable
fun ProfileCard(
    email: String,
    phone: String,
    location: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            InfoItem(
                icon = Icons.Default.Email,
                label = "Email",
                value = email
            )
            Divider(thickness = 0.5.dp, color = Color.LightGray)
            InfoItem(
                icon = Icons.Default.Phone,
                label = "Phone",
                value = phone
            )
            Divider(thickness = 0.5.dp, color = Color.LightGray)
            InfoItem(
                icon = Icons.Default.LocationOn,
                label = "Location",
                value = location
            )
        }
    }
}

// Layar Utama Menyatukan Seluruh Komponen
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileHeader(
            name = "Habbi Widagdo",
            bio = "Mobile App Developer | Teknik Informatika ITERA"
        )

        ProfileCard(
            email = "habbi.123140204@student.itera.ac.id",
            phone = "+62 812-3456-7890",
            location = "Lampung, Indonesia"
        )

        Button(
            onClick = { /* Action callback */ },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text("Edit Profile")
        }
    }
}