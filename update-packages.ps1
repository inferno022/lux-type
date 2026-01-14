# Script to update package declarations
Get-ChildItem -Path "java\src\org\luxtype" -Recurse -Filter "*.kt" | ForEach-Object {
    $content = Get-Content $_.FullName
    $newContent = $content -replace 'package org\.futo', 'package org.luxtype'
    Set-Content $_.FullName $newContent
}

Get-ChildItem -Path "common\src\org\luxtype" -Recurse -Filter "*.kt" | ForEach-Object {
    $content = Get-Content $_.FullName
    $newContent = $content -replace 'package org\.futo', 'package org.luxtype'
    Set-Content $_.FullName $newContent
}

Get-ChildItem -Path "java\playstore\java\org\luxtype" -Recurse -Filter "*.kt" | ForEach-Object {
    $content = Get-Content $_.FullName
    $newContent = $content -replace 'package org\.futo', 'package org.luxtype'
    Set-Content $_.FullName $newContent
}

Get-ChildItem -Path "voiceinput-shared\src\main\java\org\luxtype" -Recurse -Filter "*.kt" | ForEach-Object {
    $content = Get-Content $_.FullName
    $newContent = $content -replace 'package org\.futo', 'package org.luxtype'
    Set-Content $_.FullName $newContent
}

Write-Host "Package declarations updated from org.futo to org.luxtype"
