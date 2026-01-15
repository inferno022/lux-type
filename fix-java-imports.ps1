# Fix ALL remaining org.futo imports in Java files
Write-Host "Fixing ALL remaining org.futo imports..."

# Get all Java files
$javaFiles = Get-ChildItem -Path "java\src\org\luxtype" -Recurse -Filter "*.java"

$fixedCount = 0
$totalCount = $javaFiles.Count

Write-Host "Found $totalCount Java files to fix..."

foreach ($file in $javaFiles) {
    $content = Get-Content $file.FullName
    $originalContent = $content
    
    # Replace all org.futo imports with org.luxtype
    $content = $content -replace 'import org\.futo\.', 'import org.luxtype.'
    $content = $content -replace 'package org\.futo\.', 'package org.luxtype.'
    
    if ($content -ne $originalContent) {
        Set-Content $file.FullName $content
        $fixedCount++
        Write-Host "Fixed: $($file.Name)"
    }
}

Write-Host ""
Write-Host "================================"
Write-Host "JAVA IMPORT FIX COMPLETE!"
Write-Host "Fixed $fixedCount out of $totalCount files"
Write-Host "================================"
