# MASSIVE IMPORT FIX - Update all org.futo imports to org.luxtype
Write-Host "Starting massive import fix..."

# Get all Kotlin files
$ktFiles = Get-ChildItem -Path "java\src\org\luxtype" -Recurse -Filter "*.kt"

$fixedCount = 0
$totalCount = $ktFiles.Count

Write-Host "Found $totalCount Kotlin files to fix..."

foreach ($file in $ktFiles) {
    $content = Get-Content $file.FullName
    $originalContent = $content
    
    # Replace all import statements
    $content = $content -replace 'import org\.futo\.', 'import org.luxtype.'
    $content = $content -replace 'import org\.futo\.', 'import org.luxtype.'
    $content = $content -replace 'import static org\.futo\.', 'import static org.luxtype.'
    
    # Replace other references
    $content = $content -replace 'org\.futo\.', 'org.luxtype.'
    $content = $content -replace 'org\.futo::', 'org.luxtype::'
    
    if ($content -ne $originalContent) {
        Set-Content $file.FullName $content
        $fixedCount++
        Write-Host "Fixed: $($file.Name)"
    }
}

Write-Host ""
Write-Host "================================"
Write-Host "IMPORT FIX COMPLETE!"
Write-Host "Fixed $fixedCount out of $totalCount files"
Write-Host "================================"
