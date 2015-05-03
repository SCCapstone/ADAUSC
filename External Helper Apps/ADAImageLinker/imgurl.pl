#!/usr/bin/perl
#this was used to rename the image references in the full html file

use Image::Compare;
use Image::Size;
use strict;
use warnings;

print "Analyzing images...\n";

#get file names
my $directory = 'ada';

#original file names (ADA-ABxxx.gif)
my @filesOrig = <$directory/*>;

for (my $i = 0; $i < @filesOrig; $i++) {
  print @filesOrig[$i]."\n";
}

$directory = 'ADAGIFs';

#new filenames (diagramxxx.gif)
my @filesNew = <$directory/*>;

for (my $i = 0; $i < @filesNew; $i++) {
  print @filesNew[$i]."\n";
}

#open html files for reading and writing
open (FILE, '2010ADAStandards.htm');
my $newHTM = 'new.htm';
open (my $fh, '>', $newHTM) or die "Could not open '$newHTM' $1"; #open OR DIE!!

while (<FILE>) {
  chomp;
  my $beginIndex;
  my $endIndex;
  my $htmlline = $_;
  if ($htmlline =~ m/<img src=\"images\//g) {
    print $htmlline."\n";
    $beginIndex = pos($htmlline);
    print $beginIndex."\n";
    if ($htmlline =~ m/\"/g) {
      $endIndex = pos($htmlline) - 1;
      print $endIndex."\n";
    }
    my $imgPath = substr $htmlline, $beginIndex, $endIndex - $beginIndex;
    print $imgPath."\n";

    #compare images
    my $oldFile;
    my $newFile;
    for (my $i = 0; $i < @filesNew; $i++) {
      $oldFile = "ada/".$imgPath;
      $newFile = @filesNew[$i];
      print "Comparing ".$oldFile." and ".$newFile."... ";
      my ($oldX, $oldY, $newX, $newY); #for image size comparison
      ($oldX, $oldY) = imgsize($oldFile);
      ($newX, $newY) = imgsize($newFile);
      if ($oldX != $newX or $oldY != $newY) {
        print "image sizes differ\n";
      }
      else {
        print "testing... ";
        my($cmp) = Image::Compare->new();
        $cmp->set_image1(
          img => $oldFile,
        );
        $cmp->set_image2(
          img => $newFile,
        );
        $cmp->set_method(
          method => &Image::Compare::EXACT,
        );
        if ($cmp->compare()) {
          print $oldFile." and ".$newFile." are the same\n";
          splice(@filesNew, $i, 1); #remove item from array if found
          last; #break
        }
        else {
          print $oldFile." and ".$newFile." are different\n";
        }
      }
    }
    #replace image path
    pos($htmlline) = 0;
    if (@filesNew > 0) {
      $htmlline =~ s/images\/\Q$imgPath/file\:\/\/\/android_asset\/$newFile/g; #\Q autoescapes tricky chars
    }
  }
  print $fh $htmlline;
}
close (FILE);
close $fh;
print "done\n";
